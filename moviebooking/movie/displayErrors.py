
from django.shortcuts import render, redirect
from django.contrib import messages

def returnError(request, message, fileName, error):
    messages.error(request, message)
    return render(request,fileName, {'error':error})