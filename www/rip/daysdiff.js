let souls = 0;
let ghosts = 4;

function setSouls() {
    document.write('<span id="souls">' + souls + '</span>');
}
function setGhosts() {
    document.write('<span id="ghosts">' + ghosts + '</span>');
}
function daysSinceUpdate() {
    var date1 = new Date('01/07/2020');
    var date2 = new Date(Date.now());
    var diffDays = date2.getDate() - date1.getDate();
    if (document.getElementById) {
        document.write('<span id="dayCount">' + diffDays + '</span>');
        storeText = document.getElementById("highlight")
    } else {
        document.write(text);
    }
}