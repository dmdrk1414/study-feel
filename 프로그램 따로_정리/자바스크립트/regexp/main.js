const str = `
010-1234-5678
the
dmdrk1414@gmail.com 
The quick brown fox jumps over the lazy dog.
aaaaaaaabbbbbbbbbbbbbcccccccccccccdddddddddddddd.
`;

// (?=) 앞쪽 일치 . 임의의 문자
console.log(str.match(/.{1,}(?=@)/g));

// (?<=) 뒷쪽 일치 . 임의의 문자
console.log(str.match(/(?<=@).{1,}/g));
