from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='home'),
    path('busca/', views.search, name='busca'),
    path('contato/<int:id>', views.contato, name='contato'),
    path('contato/<int:id>/delete', views.delete, name='delete'),
    path('contato/<int:id>/edit', views.edit, name='edit'),
    path('contato/create', views.create, name='create'),
]
