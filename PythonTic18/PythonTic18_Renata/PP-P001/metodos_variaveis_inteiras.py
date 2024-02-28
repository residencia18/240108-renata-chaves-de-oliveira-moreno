# metodos_variaveis_inteiras.py

num = 42

# Métodos disponíveis para variáveis inteiras
print("bit_length:", num.bit_length())
print("to_bytes:", num.to_bytes(2, byteorder='big'))
print("from_bytes:", int.from_bytes(b'*\x00', byteorder='big'))
