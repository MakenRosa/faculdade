import logging

logging.basicConfig(level=logging.DEBUG, format='%(asctime)s - %(levelname)s - %(message)s', datefmt='%d/%m/%Y %H:%M:%S', filename='aula001.log', filemode='w')

nota = 10

if nota >= 7:
    logging.debug('Aprovado')
elif nota >= 5:
    logging.debug('Recuperação')
else:
    logging.debug('Reprovado')