from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
   return render(request,'homepg_html/home_page.html')

        

def signup(request):    
    return render(request,'customer_html/Signup.html')

def login(request):    
    return render(request,'customer_html/login.html') 