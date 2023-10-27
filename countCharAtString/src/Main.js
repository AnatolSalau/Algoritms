
function rle(str) {
      if(str.match(/[^A-Z]/g)) {
            throw new Error(`${str} is invalid!`);
      }

      let result = '';

      for(let i = 0; i < str.length; i++) {
            let char = str[i];
            let j = i;

            if(char === str[++j]) {
                  let count = 1;

                  while (char === str[j++]) {
                        count++;
                  }

                  result += `${char}${count}`;
                  i += count - 1;
            } else {
                  result += char;
            }
      }

      return result;
}
console.log("Expected result : " + "A4B3C2XYZD4E3F3A6B28")
console.log(rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB")); //"A4B3C2XYZD4E3F3A6B28"

