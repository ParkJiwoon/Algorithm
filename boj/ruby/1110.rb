# https://www.acmicpc.net/problem/1110 - 더하기 사이클

n = gets.chomp()

if n.to_i < 10
    num = "0" + n
else
    num = n
end

i = 1
while true do
    sum = num[0].to_i + num[1].to_i
    num = num[1] << (sum.to_i%10).to_s
    
    # n이 1일때 num이 01일 경우도 체크
    if num == n || num == "0" << n
        puts i
        exit
    end
    
    i += 1
end
