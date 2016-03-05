'use strict';
angular.module('me.lazerka.worktimer', [])
	.controller('MainController', function($http) {
		var scope = this;
		$http.get('/api/interval/list')
			.then(show, showError);

		function show(response) {
			scope.intervals = response.data;
			scope.error = null;
		}

		function showError(response) {
			scope.error = response;
		}

	})
;
