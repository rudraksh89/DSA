/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
    let st = []
    for(let i=0;i<s.length;i++){
        if(st.length > 0 && s[i] == st[st.length-1]) st.pop();
        else st.push(s[i]);
    }
    let ans = "";
    while(st.length > 0){
        ans += st.pop();
    }
    return ans.split("").reverse().join("");
};
