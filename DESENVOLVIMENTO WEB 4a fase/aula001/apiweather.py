import requests
import tkinter as tk


def buscar():
    response = requests.get(f'https://weather.contrateumdev.com.br/api/weather/city/?city={cidade.get()}')
    if response.status_code == 200:
        response = response.json()
        temperatura = response['main']['temp']
        minima = response['main']['temp_min']
        maxima = response['main']['temp_max']
        ceu = response['weather'][0]['description']
        tk.Label(window, text=f'Temperatura: {temperatura}').grid(row=2, column=0, columnspan=2)
        tk.Label(window, text=f'Mínima: {minima}').grid(row=3, column=0, columnspan=2)
        tk.Label(window, text=f'Máxima: {maxima}').grid(row=4, column=0, columnspan=2)
        tk.Label(window, text=f'Céu: {ceu}').grid(row=5, column=0, columnspan=2)
    else:
        tk.Label(window, text='Cidade não encontrada').grid(row=2, column=0, columnspan=2)

window = tk.Tk()
window.title('API Weather')
window.geometry('200x140')
tk.Label(window, text='Cidade:').grid(row=0, column=0)
cidade = tk.Entry(window)
cidade.grid(row=0, column=1)
tk.Button(window, text='Buscar', command=buscar).grid(row=1, column=0, columnspan=2)
window.mainloop()