// In FP, Destructuring is about extracting data from the innards of any structure.
// Destructuring list (or use as n-Tuple)
// Show this first
const list = [1,2,3,4,5,6]
let [first, second] = list
console.info("first = ", first);
console.info("second = ", second);
// Destructuring gives us a short-hand way of naming parts of the data-structure.
// then show by Adding to the above ...rest
[first, second, ...rest] = list
console.info("rest = ", rest);

// Destructuring Object
const name = {first: "Dhaval", last: "Dalal", salutation: 'Mr.'};
const {first: firstName, last: lastName} = name;
console.info(firstName);
console.info(lastName);

// Destructuring Function params
function capitalize({first: firstName, last: lastName}){
  return firstName.toUpperCase() + " " + lastName.toUpperCase();
}
console.info(capitalize(name));

// Destructuring Function params
function distance([x1,y1], [x2,y2]){
  return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
}

console.info(distance([0,0], [0,0]))
console.info(distance([3,0], [0,0]))
console.info(distance([0,0], [0,4]))
console.info(distance([3,0], [0,4]))

// No need to show this - skip.
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
