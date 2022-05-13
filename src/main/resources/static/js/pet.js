const petsTable = $("#petsTable");
$(document).ready(function() {

	$.ajax({
		type: "GET",
		// Formato de datos que se espera en la respuesta
		dataType: "json",
		// URL a la que se enviará la solicitud Ajax
		url: "/pets",
		contentType: 'application/json'
	})
		.done(function(data, textStatus, jqXHR) {
			console.log(data);
			petsTable.bootstrapTable({
				data: data.body,
				pagination: true,
				search: true,
				pageSize: 5,
				pageList: [5, 10],
				locale: "es-ES",
				columns: [{
					field: 'id',
					title: 'ID',
					width: '40px'
				}, {
					field: 'name',
					title: 'Name',
					width: '180px'
				}, {
					field: 'type',
					title: 'Type',
					width: '180px'
				}, {
					field: 'owner',
					title: 'Owner',
					width: '180px'
				}, {
					field: 'detail',
					title: 'Detail',
					width: '180px'
				}, {
					field: 'status',
					title: 'Status',
					width: '180px'
				}
				]
			});

		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
		});

	$("#idBtnSavePet").click(function() {

		const isNewPetOk = () => {

			var idName = false;
			var idType = false;
			var idOwner = false;
			var idDetail = false;
			var idStatus = false;

			if ($("#idName").val().length == 0) {
				$("#idName").addClass("is-invalid");
				$("#idName").removeClass("is-valid");
				idName = false;
			} else {
				$("#idName").removeClass("is-invalid");
				$("#idName").addClass("is-valid");
				idName = true;
			} if ($("#idType").val().length == 0) {
				$("#idType").addClass("is-invalid");
				$("#idType").removeClass("is-valid");
				idType = false;
			} else {
				$("#idType").removeClass("is-invalid");
				$("#idType").addClass("is-valid");
				idType = true;
			} if ($("#idOwner").val().length == 0) {
				$("#idOwner").addClass("is-invalid");
				$("#idOwner").removeClass("is-valid");
				idOwner = false;
			} else {
				$("#idOwner").removeClass("is-invalid");
				$("#idOwner").addClass("is-valid");
				idOwner = true;
			} if ($("#idDetail").val().length == 0) {
				$("#idDetail").addClass("is-invalid");
				$("#idDetail").removeClass("is-valid");
				idDetail = false;
			} else {
				$("#idDetail").removeClass("is-invalid");
				$("#idDetail").addClass("is-valid");
				idDetail = true;
			} if ($("#idStatus").val().length == 0) {
				$("#idStatus").addClass("is-invalid");
				$("#idStatus").removeClass("is-valid");
				idStatus = false;
			} else {
				$("#idStatus").removeClass("is-invalid");
				$("#idStatus").addClass("is-valid");
				idStatus = true;
			}
			return idName && idType && idOwner && idDetail && idStatus;
		}

		if (isNewPetOk()) {
			console.log("Everything is going to be alright");

			let dataPet = {
				"name": $("#idName").val(),
				"type": $("#idType").val(),
				"owner": $("#idOwner").val(),
				"detail": $("#idDetail").val(),
				"status": $("#idStatus").val(),
			}

			$.ajax({
				// En data puedes utilizar un objeto JSON, un array o un query string
				data: JSON.stringify(dataPet),
				type: "POST",
				dataType: "json",
				url: "/pets",
				contentType: 'application/json'
			})
				.done(function(data, textStatus, jqXHR) {
					swal({
						text: data.message,
						icon: "success"
					});
					console.log("La solicitud se ha completado correctamente.", data, textStatus, jqXHR);
					petsTable.bootstrapTable('load', data.body);
					petsTable.bootstrapTable('refresh');
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					console.log("La solicitud a fallado: ", errorThrown, textStatus, jqXHR);
				})

		} else {
			console.log("nothing in here");
		}

	});
});