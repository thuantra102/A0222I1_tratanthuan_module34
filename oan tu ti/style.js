let cases = 0;

// lost cases= 1 va win  cases = 2 que la case 3

function resultGame(indexOfPeople, indexAuto) {
  if (indexOfPeople == 2 && indexAuto == 1) {
    cases = 1;
  } else if (indexOfPeople == 0 && indexAuto == 1) {
    cases = 2;
  } else if (indexOfPeople == 0 && indexAuto == 2) {
    cases = 1;
  } else if (indexOfPeople == 1 && indexAuto == 0) {
    cases = 1;
  } else if (indexOfPeople == 1 && indexAuto == 2) {
    cases = 2;
  } else if (indexOfPeople == 2 && indexAuto == 0) {
    cases = 2;
  } else {
    cases = 3;
  }

  return cases;
}

function choosePicture(indexOfPct) {
  let pct = document.getElementById("resultOfPct");
  if (indexOfPct == 0) {
    pct.innerHTML = '<img src="logo/bua-logo.png" class="logo-auto" id="pct">';
  } else if (indexOfPct == 1) {
    pct.innerHTML = '<img src="logo/keo-logo.png" class="logo-auto" id="pct">';
  } else {
    pct.innerHTML = '<img src="logo/bao-logo.jfif" class="logo-auto" id="pct">';
  }
}
let countPeopleWin = 0;
let countAutoWin = 0;

function getValuePeople(indexPeople) {
  let scoreAuto = document.getElementById("scoreAuto");
  let scorePeople = document.getElementById("scorePeople");
  let resultOfGameIs = document.getElementById("resultOfGame");
  let indexAuto = Math.floor(Math.random() * 3);
  let cases = resultGame(indexPeople, indexAuto);
  if (cases == 1) {
    resultOfGameIs.innerText = "Bạn thua rồi";
    countAutoWin++;
  } else if (cases == 2) {
    resultOfGameIs.innerText = "Bạn Thắng Rồi";
    countPeopleWin++;
  } else {
    resultOfGameIs.innerText = "Quề Nha";
  }
  choosePicture(indexAuto);

  scorePeople.innerText = countPeopleWin;
  scoreAuto.innerText = countAutoWin;
  if (countAutoWin == 3) {
    alert("Bạn thua rồi");
    scorePeople.innerText = "0";
    scoreAuto.innerText = "0";
    countAutoWin = 0;
    countPeopleWin = 0;
  }
  if (countPeopleWin == 3) {
    alert("Bạn chiến thắng");
    scorePeople.innerText = "0";
    scoreAuto.innerText = "0";
    countPeopleWin = 0;
    countAutoWin = 0;
  }
}
