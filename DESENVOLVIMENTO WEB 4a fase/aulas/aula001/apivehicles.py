import requests
#usando api openweather
response = requests.get('https://api.openweathermap.org/data/2.5/weather?q=London&appid=4b3b4c4c4c4c4c4c4c4c4c4c4c4c4c4c')
response = response.json()
print(response)