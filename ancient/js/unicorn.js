//----SETTINGS----
const text = "Dom's The Unicorn Project";
const speedOfFade = 64;
//----------------

let storeText;
if (document.getElementById) {
    document.write('<h1 id="highlight">' + text + '</h1>');
    storeText = document.getElementById("highlight")
} else
    document.write(text);
const hex = ["00", "07", "14", "21", "28", "3C", "50", "64", "78", "8C", "A0", "B4", "C8", "DC", "F0"];
let r = 1;
let g = 1;
let b = 1;
let seq = 1;

function changeText() {
    storeText.style.color = `#${hex[r]}${hex[g]}${hex[b]}`
}

function change() {
    if (seq === 6) {
        b--;
        if (b === 0)
            seq = 1
    }
    if (seq === 5) {
        r++;
        if (r === 12)
            seq = 6
    }
    if (seq === 4) {
        g--;
        if (g === 0)
            seq = 5
    }
    if (seq === 3) {
        b++;
        if (b === 12)
            seq = 4
    }
    if (seq === 2) {
        r--;
        if (r === 0)
            seq = 3
    }
    if (seq === 1) {
        g++;
        if (g === 12)
            seq = 2
    }
    changeText()
}


function displayTitle() {
    if (document.getElementById)
        flash = setInterval("change()", speedOfFade)
}