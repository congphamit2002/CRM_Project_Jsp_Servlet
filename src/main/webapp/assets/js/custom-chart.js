(function($) {

	"use strict"; // Start of use strict

	var countUnprocess = $("#count-unprocess").val();
	var countProcessing = $("#count-processing").val();
	var countComplete = $("#count-complete").val();
	var SufeeAdmin = {

		pieFlot: function() {

			var data = [
				{
					label: "Chưa thực hiện",
					data: countUnprocess,
					color: "rgb(56 147 229)"
				},
				{
					label: "Đang thực hiện",
					data: countProcessing,
					color: "#02c543"
				},
				{
					label: "Hoàn thành",
					data: countComplete,
					color: "#df941a"
				}
			];

			var plotObj = $.plot($("#flot-pie"), data, {
				series: {
					pie: {
						show: true,
						radius: 1,
						label: {
							show: false,

						}
					}
				},
				grid: {
					hoverable: true
				},
				tooltip: {
					show: true,
					content: "%p.0%, %s, n=%n", // show percentages, rounding to 2 decimal places
					shifts: {
						x: 20,
						y: 0
					},
					defaultTheme: false
				}
			});
		},


		singlePlot: function() {
			// single bar chart
			var ctx = document.getElementById("singelBarChart");
			ctx.height = 150;
			var myChart = new Chart(ctx, {
				type: 'bar',
				data: {
					labels: ["Chưa thực hiện", "Đang thực hiện", "Hoàn thành"],
					datasets: [
						{
							label: "Công việc",
							data: [countUnprocess, countProcessing, countComplete],
							borderColor: "rgba(0, 194, 146, 0.9)",
							borderWidth: "0",
							backgroundColor: "rgba(0, 194, 146, 0.5)"
						}
					]
				},
				options: {
					scales: {
						yAxes: [{
							ticks: {
								beginAtZero: true
							}
						}]
					}
				}
			});
		}

	};

	$(document).ready(function() {
		SufeeAdmin.pieFlot();
		SufeeAdmin.singlePlot();
	});

})(jQuery);
