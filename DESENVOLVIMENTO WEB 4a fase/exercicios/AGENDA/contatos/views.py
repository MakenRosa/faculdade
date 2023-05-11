from django.shortcuts import render, HttpResponse, redirect
from django.core.paginator import Paginator
from . models import Contatos

# Create your views here.
def index(request):
    contatos_list = Contatos.objects.all()
    paginator = Paginator(contatos_list, 10)
    page_number = request.GET.get('page')
    contatos = paginator.get_page(page_number)
    return render(request, 'pages/index.html', {'contatos':contatos})
    


def search(request): 
    q = request.GET.get('search')   
    contatos = Contatos.objects.filter(nome__icontains=q)    
    return render(request, 'pages/index.html', {'contatos':contatos})

def contato(request, id):
    if request.method == 'POST':
        nome = request.POST.get('nome')
        cpf = request.POST.get('cpf')
        email = request.POST.get('email')
        telefone = request.POST.get('telefone')
        altura = request.POST.get('altura')
        descricao = request.POST.get('descricao')
        data_nascimento = request.POST.get('data_nascimento')
        ativo = request.POST.get('ativo')
        
        contato = Contatos.objects.get(id=id)
        contato.nome = nome
        contato.cpf = cpf
        contato.email = email
        contato.telefone = telefone
        contato.altura = altura
        contato.descricao = descricao
        contato.data_nascimento = data_nascimento
        contato.ativo = ativo
        contato.save()
        return redirect('contato', id=id)
    contato = Contatos.objects.get(id=id)
    return render(request, 'pages/contato.html', {'contato':contato})

def delete(id):
    contato = Contatos.objects.get(id=id)
    contato.delete()
    return redirect('home')

def edit(request, id):
    contato = Contatos.objects.get(id=id)
    return render(request, 'pages/edit.html', {'contato':contato})

def create(request):
    if request.method == 'POST':
        nome = request.POST.get('nome')
        cpf = request.POST.get('cpf')
        email = request.POST.get('email')
        telefone = request.POST.get('telefone')
        altura = request.POST.get('altura')
        descricao = request.POST.get('descricao')
        data_nascimento = request.POST.get('data_nascimento')
        ativo = request.POST.get('ativo')
        
        contato = Contatos.objects.create(
            nome=nome,
            cpf=cpf,
            email=email,
            telefone=telefone,
            altura=altura,
            descricao=descricao,
            data_nascimento=data_nascimento,
            ativo=ativo
        )
        contato.save()
        return redirect('home')
    return render(request, 'pages/create.html')