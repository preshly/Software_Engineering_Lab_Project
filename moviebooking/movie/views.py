from django.shortcuts import render, redirect
from django.http import HttpResponse
from .forms import CustomerSignupForm
from .models import Customer
# Create your views here.

def index(request):
   return render(request,'homepg_html/home_page.html')

        

def customerSignup(request):
    if request.method == 'POST':
        customerForm = CustomerSignupForm(request.POST)
        
        if customerForm.is_valid():
          
            
            username = customerForm.data['username']
            email = customerForm.data['email']
            password = customerForm.data['password']

            customer = Customer(username=username, email=email, password=password)
            customer.save()
            
           

            return redirect('customerLogin')
        else:
            return render(request,'customer_html/Signup.html')

    return render(request,'customer_html/Signup.html')

def customerLogin(request):
    if request.method == 'POST':
        username = request.POST['username'] 
        password = request.POST['password'] 
        
        customer = Customer.objects.get(username=username)
        
        originalPassword = customer.password
        
        if not originalPassword == None:
           
            if originalPassword == password:
                request.session['username'] = username
                customer.is_active = True
                customer.save()
                print(request.session['username'])
                print(customer.is_active)
                return redirect('customerHome')
        else:
            
            return render(request,'customer_html/login.html')
    
    return render(request,'customer_html/login.html')

def customerHome(request):
    if request.session['username'] != None:
        return render(request,'homepg_html/customer_home.html')
    else:
        return redirect('index')

def customerLogout(request):
    if request.session['username'] != None:
        
        customer = Customer.objects.get(username=request.session['username'] )
        print(customer.is_active)
        customer.is_active = False
        customer.save()
        request.session['username'] = None
        print(customer.is_active)
        
        return render(request,'homepg_html/home_page.html')
    else:
        return redirect('index')