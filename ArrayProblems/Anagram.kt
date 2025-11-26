package ArrayProblems


fun main() {
    println(isAnagram("attyy","aytyt"))
}

fun isAnagram(s1: String, s2: String): Boolean {
    // code goes here

    if(s1.length != s2.length){
        return false
    }

    val hashMap = HashMap<Char, Int>()

    for(ch in s1.toCharArray()){
        if(hashMap.containsKey(ch)){
            hashMap.put(ch,(hashMap.get(ch)?:0)+1)
        }
        else {
            hashMap.put(ch, 1)
        }
    }


    for(ch in s2.toCharArray()){
        if(hashMap.containsKey(ch)){
            hashMap.put(ch,(hashMap.get(ch)?:0) - 1)
        }
        else {
            hashMap.put(ch, 1)
        }
    }


    for(v in hashMap.entries.toList()){
        if(v.value != 0){
            return false
        }
    }

    return true

}