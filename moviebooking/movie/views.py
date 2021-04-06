from django.shortcuts import render, redirect
from django.http import HttpResponse
from .forms import CustomerSignupForm
from .models import Customer,Movie
from .displayErrors import returnError
from django.contrib import messages

# Create your views here.

def index(request):
   movies = Movie.objects.raw('SELECT * FROM movie_movie order by random() limit 4')
   return render(request,'homepg_html/home_page.html', {'movie': movies})

        

def customerSignup(request):
    if request.method == 'POST':
        customerForm = CustomerSignupForm(request.POST)

        if customerForm.errors['username'] == ['Customer with this Username already exists.'] :
            message = 'The username is already used. Please use anther username.'
            error = 0
            messages.error(request, message)
            return render(request,'customer_html/Signup.html', {'error': error} )
        
        if customerForm.is_valid():
    
            username = customerForm.data['username']
            email = customerForm.data['email']
            password = customerForm.data['password']

            
            customer = Customer(username=username, email=email, password=password)
            customer.save()
        
            #return redirect(customerLogin)
            return returnError(request, 
                'Your account is succefully created. Please login with your credentials.', 
                'customer_html/login.html', 1)

    return render(request,'customer_html/Signup.html')

def customerLogin(request):
    if request.method == 'POST':
        username = request.POST['username'] 
        password = request.POST['password'] 
        
        try:
            customer = Customer.objects.get(username=username)
            
            originalPassword = customer.password
            
            if not originalPassword == None:
            
                if originalPassword == password:
                    request.session['username'] = username
                    customer.is_active = True
                    customer.save()
                    return redirect(customerHome)
                else:
                    return returnError(request, 'Incorrect Username or Password', 'customer_html/login.html', 0)
        except Customer.DoesNotExist as e:
                return returnError(request, 'Incorrect Username or Password', 'customer_html/login.html', 0)
    
    return render(request,'customer_html/login.html')

def customerHome(request):
    try:
        customer = Customer.objects.get(username=request.session['username'] )
        if request.session['username'] != None:
            movies = Movie.objects.raw('SELECT * FROM movie_movie order by random() limit 4')
            message = 'You are logged in as \'' + customer.username + '\''
            error = 1
            messages.success(request, message)
            return render(request,'homepg_html/customer_home.html', {'movie': movies, 'error': error, 'username':'  ' + customer.username})

    except customer.DoesNotExist as e:
        return redirect(index)
 
def customerLogout(request):
    if request.session['username'] != None:
        
        customer = Customer.objects.get(username=request.session['username'] )
        customer.is_active = False
        customer.save()
        request.session['username'] = None
        
        return redirect(index)

