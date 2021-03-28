from django.contrib import admin
from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index, name='movieIndex'),
    path('login/', views.login, name='customerLogin'),
    path('signup/', views.signup, name='customerSignup'),
] 

admin.site.site_header = 'Movie Booking'
admin.site.site_title = 'Movie Booking'
admin.site.index_title = 'Welcome to the Admin page'