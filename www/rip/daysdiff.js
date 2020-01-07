let souls = 0;
let ghosts = 4;
let records = 6;

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
    let date1 = new Date('01/07/2020');
    let date2 = new Date(Date.now());
    let diffDays = date2.getDate() - date1.getDate();
    document.write('<span id="dayCount">' + diffDays + '</span>');
}
