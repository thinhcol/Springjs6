function generateColor() {
	let r = parseInt(Math.random() * 255);
	let g = parseInt(Math.random() * 255);
	let b = parseInt(Math.random() * 255);
	return `rgb(${r},${g},${b}, 0.5)`
}
function bodermau() {
	let r = parseInt(Math.random() * 255);
	let g = parseInt(Math.random() * 255);
	let b = parseInt(Math.random() * 255);
	return `rgb(${r},${g},${b}, 1)`
}
function doughnut (id, view = [], tittle = []) {
	let colors = []
	for (let i = 0; i < view.length; i++) {
		colors.push(generateColor())
		
	}
	
	const data = {
		labels: tittle,
		datasets: [{
			label: 'Thống kê',
			data: view,
			backgroundColor: colors,
			hoverOffset: 4
		}]
	};
	const config = {
		type: 'doughnut',
		data: data,
	};
	let ctx = document.getElementById(id).getContext("2d")
	new Chart(ctx, config)
}
function linechart(id, view = [], tittle = []) {
	let colors = []
	for (let i = 0; i < view.length; i++) {
		colors.push(generateColor())
	}
	const data = {
		labels: tittle,
		datasets: [{
			label: 'Lượt mua ',
			data: view,
			fill: false,
			backgroundColor: colors,
			borderWidth: 1,
			borderColor: 181616
		}]
	};
	const config = {
		type: 'bar',
		data: data,
		options: {
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero: true
					},
					gridLines: {
						color: "rgba(204, 204, 204,0.1)"
					}
				}],
				xAxes: [{
					gridLines: {
						color: "rgba(204, 204, 204,0.1)"
					}
				}]
			},
			legend: {
				display: false
			},
			elements: {
				point: {
					radius: 0
				}
			}
		},
	};
	let ctx = document.getElementById(id).getContext("2d")
	new Chart(ctx, config)
}