let souls = 0;
let ghosts = 5;
let records = 6;
let lastChange = '01/08/2020';

function setSouls() {
    document.write('<span id="souls">' + souls + '</span>');
}

function setGhosts() {
    document.write('<span id="ghosts">' + ghosts + '</span>');
}

function setRecords() {
    document.write('<span id="records">' + records + '</span>')
}

function daysSinceUpdate() {
    let date1 = new Date(lastChange);
    let date2 = new Date(Date.now());
    let diffDays = date2.getDate() - date1.getDate();
    document.write('<span id="dayCount">' + diffDays + '</span>');
}
