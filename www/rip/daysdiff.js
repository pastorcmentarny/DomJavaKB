//config
let souls = 1;
let ghosts = 8;
let records = 8;
let lastChange = '01/21/2020';


function setSouls() {
    document.write('<span id="souls">' + souls + '</span><br/>');
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

