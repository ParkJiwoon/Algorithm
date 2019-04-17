# https://www.acmicpc.net/problem/10430 - 나머지

a, b, c = gets.chomp().split
a, b, c = a.to_i, b.to_i, c.to_i
puts (a+b)%c, (a%c + b%c)%c, (a*b)%c, (a%c * b%c)%c