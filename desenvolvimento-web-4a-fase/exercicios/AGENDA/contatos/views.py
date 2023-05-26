from django.shortcuts import render, redirect
from django.contrib import messages
from django.core.paginator import Paginator
from . models import Contatos

# Create your views here.
def index(request):
    # if you want reverse order, use this:
    # contatos_list = Contatos.objects.all().order_by('-id')
    # if you want to filter, use this:

    contatos_list = Contatos.objects.filter(ativo=True).order_by('id')
    paginator = Paginator(contatos_list, 10)
    page_number = request.GET.get('page')
    contatos = paginator.get_page(page_number)
    return render(request, 'pages/index.html', {'contatos':contatos})
    


def search(request): 
    q = request.GET.get('search')   
    contatos_list = Contatos.objects.filter(nome__icontains=q)
    paginator = Paginator(contatos_list, 10)
    page_number = request.GET.get('page')
    contatos = paginator.get_page(page_number)
    return render(request, 'pages/index.html', {'contatos':contatos, 'q':q})



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
        foto_url = request.POST.get('foto_url')
        
        contato = Contatos.objects.get(id=id)
        contato.nome = nome
        contato.cpf = cpf
        contato.email = email
        contato.telefone = telefone
        contato.altura = altura
        contato.descricao = descricao
        contato.data_nascimento = data_nascimento
        contato.ativo = ativo
        contato.foto_url = foto_url
        contato.save()
        messages.success(request, 'Contato atualizado com sucesso!')
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
        foto_url = request.POST.get('foto_url')
        
        contato = Contatos.objects.create(
            nome=nome,
            cpf=cpf,
            email=email,
            telefone=telefone,
            altura=altura,
            descricao=descricao,
            data_nascimento=data_nascimento,
            ativo=ativo,
            foto_url=foto_url
        )
        contato.save()
        messages.success(request, 'Contato criado com sucesso!')
        return redirect('home')
    return render(request, 'pages/create.html')