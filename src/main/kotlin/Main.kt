fun main() {
    // take cross-hair input from user
    println("Enter cross hair code: ")
    val code = readLine()!!
    processCode(code)
}

fun processCode(crossHairCode: String)
{
    // -----------------EXAMPLES----------------------
    // 0;p;0;s;1;P;c;1;h;0;0t;4;0l;1;0o;2;0a;1;0f;0;1b;0;A;c;1;o;1;d;1;0b;0;1b;0;S;c;1;s;1.078;o;1 <-- just a green dot
    // 0;P;c;1;o;1;f;0;0t;1;0l;2;0o;2;0a;1;0f;0;1b;0 <-- no center dot, green with inner lines
    // 0;s;1;P;c;4;t;2;o;1;0t;10;0o;0;0a;1;0f;0;1t;3;1l;3;1o;0;1a;0;1m;0;1f;0 <-- danny's smiley :)
    // -----------------END---------------------------

    // separate the code with delimiter being uppercase letters
    val parts = crossHairCode.split("(?<=.)(?=\\p{Lu})".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

    val primary = parts[1]
    val ads = parts[2]
    val sniper = parts[3]

    processPrimary(primary)

}

fun processPrimary(primary: String)
{
    val primaryColours = arrayOf(
        "White",
        "Green",
        "Yellow Green",
        "Green Yellow",
        "Yellow",
        "Cyan",
        "Pink",
        "Red"
    )

    // go up 4 indexes to find the colour of cross-hair
    val colour = primaryColours[primary.substring(4, 5).toInt()]

    // check if outlines are enabled
    // outlines are enabled if there is no "h" in the code
    val outlinesEnabled = !primary.contains("h")

    if (outlinesEnabled)
    {
        println("Cross hair is $colour with outlines")
    }
    else
    {
        println("Cross hair is $colour without outlines")
    }
}

