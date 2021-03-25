from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
    return HttpResponse("""<h1>Movie Home</h1>""")

def signup(request):    
    return render(request,'customer_html/Signup.html')

def login(request):    
    return render(request,'customer_html/login.html')    