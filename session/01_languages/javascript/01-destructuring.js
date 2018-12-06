const list = [1,2,3,4]

const [first, second, ...rest] = list
console.info(first, second, rest);

const name = {
	first: "Toto",
	last: "Mookey",
	salutation: "Mr."
};

const { first: firstName, last: lastName } = name
console.info(firstName, lastName);

function capitalize({ first: firstName, last: lastName }) {
	return firstName.toUpperCase() + " " + lastName.toUpperCase();
}

console.info(capitalize(name));

function midpoint([x1, y1], [x2, y2]) {
	const mid = (a1, a2) => (a1 + a2) / 2;
	return [mid(x1, x2), mid(y1, y2)];
}

console.info(midpoint([2,3], [4,5]));

const map = new Map()
	.set('a', 2)
	.set('b', 4)
	.set('c', 6)

console.info(...map);

const [[k1, v1], [k2, v2], [k3, v3]] = map
console.info(k1, v1, k2, v2, k3, v3);

