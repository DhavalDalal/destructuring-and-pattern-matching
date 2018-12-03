// In FP, Destructuring is about extracting data from the innards of any structure.
// Destructuring list (or use as n-Tuple)
const list = [1,2,3,4,5,6]
let [first, second] = list
console.info("first = ", first);
console.info("second = ", second);
// Destructuring gives us a short-hand way of naming parts of the data-structure.
[first, second, ...rest] = list
console.info("rest = ", rest);

// Destructuring Object
const name = {fName: "Dhaval", lName: "Dalal", salutation: 'Mr.'};
const {fName: firstName, lName: lastName} = name;
console.info(firstName);
console.info(lastName);

// Destructuring Function params
function midpoint([x1,y1], [x2,y2] = [0,0]) { 
  return [(x1 + x2) / 2, (y1 + y2) / 2];
}

console.info(midpoint([2,3], [4,5]));
console.info(midpoint([2,3]));

function capitalize({fName: firstName, lName: lastName}){
  return firstName.toUpperCase() + " " + lastName.toUpperCase();
}
console.info(capitalize(name));

// Destructuring Map - No direct way
const map = new Map()
  .set('a', 2)
  .set('b', 4)
  .set('c', 8);
  
console.info(map);
// so you spread the map
console.info(...map);
// and then destructure the list.
const [[fKey, fVal], [sKey,sVal], [tKey,tVal]] = [...map]
console.info(fKey, fVal, sKey, sVal, tKey, tVal);




