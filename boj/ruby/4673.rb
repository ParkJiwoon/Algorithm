# https://www.acmicpc.net/problem/4673 - 셀프 넘버

def dFunction(n)
    n.to_s.each_char do |char|
        n += char.to_i
    end
    return n
end

isSelfNumber = Array.new(10001, false)

for i in 1..10000
    isSelfNumber[dFunction(i)] = true
end

for i in 1..10000
    puts i unless isSelfNumber[i]
end