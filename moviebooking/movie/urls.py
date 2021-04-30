from django.contrib import admin
from django.urls import path
from . import views 

urlpatterns = [
    path('', views.index, name='movieIndex'),
    path('', views.autocomplete, name='autocomplete'),
    path('home_page2.html/', views.search_content, name='search_content'),
    path('login/', views.customerLogin, name='customerLogin'),
    path('logout/', views.customerLogout, name='customerLogout'),
    path('signup/', views.customerSignup, name='customerSignup'),
    path('customer_home/', views.customerHome, name='customerHome'),
    path('bookings/<int:movie_id>', views.bookings, name='bookings'),
    path('bookingMovie/', views.bookingMovie, name='movieBookings'),
    path('comments/<int:movie_id>',views.comment, name='comments'),
    path('movieComments/', views.movieComments, name='movieComments'),
] 
admin.site.site_header = 'Movie Booking'
admin.site.site_title = 'Movie Booking'
admin.site.index_title = 'Welcome to the Admin page'