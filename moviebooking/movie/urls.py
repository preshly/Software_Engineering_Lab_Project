from django.contrib import admin
from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index, name='movieIndex'),
    path('login/', views.customerLogin, name='customerLogin'),
    path('logout/', views.customerLogout, name='customerLogout'),
    path('signup/', views.customerSignup, name='customerSignup'),
    path('customer_home/', views.customerHome, name='customerHome'),
    path('bookings/<int:movie_id>', views.bookings, name='bookings'),
    path('bookingMovie/', views.bookingMovie, name='movieBookings'),

] 

admin.site.site_header = 'Movie Booking'
admin.site.site_title = 'Movie Booking'
admin.site.index_title = 'Welcome to the Admin page'