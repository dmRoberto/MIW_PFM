pwitter.PwitterControllers.controller(pwitter.controllers.editCompetitionController, function($scope, $http, $routeParams) {
	$http.get(
			pwitter.sportsURI)
			.success(function(response) {
				$scope.sports=response;
			});
	$http.get(
			pwitter.countriesURI)
			.success(function(response) {
				$scope.countries=response;
			});
	$http.get(
			pwitter.resultsURI)
			.success(function(response) {
				$scope.results=response;
			});
	$http.get(
			pwitter.competitionURI + pwitter.separator + $routeParams.competititonID)
			.success(function(response) {
				$scope.competition=response;
			});
	$scope.processForm = function(data){
        $http.put(pwitter.competitionURI, angular.toJson($scope.competition)).success(function(response){
        	$scope.result = response.message;
        });
	};
	$scope.addMatch = function(){
		if(!$scope.competition) {
			$scope.competition = {
				matchs: new Array()
			};
		} else if(!$scope.competition.matchs){
			$scope.competition.matchs = new Array();
		}
		$scope.competition.matchs.push({
			result:null,
			date:null,
			local:null,
			visitor:null
		});
	};
	$scope.removeMatch = function(){
		$scope.competition.matchs.pop();
	};
});