from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
    return HttpResponse('''
        <h1>Movie</h1>
        <br/>
        <a href='/movie/login' style="font-size:20px; text-decoration:none; color:blue;">Login </a>
        <br/> <br/>
        <a href='/movie/signup' style="font-size:20px; text-decoration:none; color:red;">Sign up </a>
        ''')

def signup(request):    
    return render(request,'customer_html/Signup.html')

def login(request):    
    return render(request,'customer_html/login.html') 