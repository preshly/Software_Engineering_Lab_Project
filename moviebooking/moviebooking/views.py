from django.shortcuts import render
from django.http import HttpResponse
# Create your views here.

def index(request):
    return HttpResponse('''
        <h1>Movie Home</h1>
        <br/>
        <a href='/movie/' style="font-size:20px; text-decoration:none; color:blue;">Visit our site </a>
        ''')

   