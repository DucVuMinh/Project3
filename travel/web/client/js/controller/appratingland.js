var starApp = angular.module('starApp', []);

starApp.controller('StarCtrl', function ($scope, $http, $location) {
    $scope.rating = 0;
    $scope.numberUserRank = 5;
    $scope.ratings = [{
            current: 2,
            max: 5,
            readonly: true,
            isClick: false
        }, {
            current: 5,
            max: 5,
            readonly: false,
            isClick: false
        }];

    $scope.getSelectedRating = function (rating) {
        console.log(rating);
        if ($scope.ratings[0].isClick) {
            var url = $location.absUrl().split('?')[1].split('=')[1];
            var rank = url + '|' + $scope.ratings[1].current;
            $http({
                method: 'POST',
                url: 'http://localhost:8080/travel/rankingland.htm',
                data: rank
            }).success(function (data, status, headers, config) {
                if (data === "login") {
                    alert("Log in to rank");
                    $scope.ratings[1].current=5;
                } else if (data === "error") {
                    alert("Reload page");
                } else {
                    alert(data);
                    var arrRespone = data.split("|");
                    alert(arrRespone[0]);
                    $scope.ratings[0].current = arrRespone[0];
                    alert("arrRespone[0]");
                    alert($scope.ratings[0].current );
                    $scope.numberUserRank = arrRespone[1];
                }
            }).error(function (data, status, headers, config) {
                alert("Network error");
            });
        }
    };
    $scope.setRate = function (val1, val2, val3) {
        $scope.ratings[0].current = val1.toFixed(1);
        $scope.ratings[1].current = val2;
        $scope.numberUserRank = val3;
        

    };
    $scope.sendRate = function () {
        alert("Thanks for your rates!\n\nFirst Rate: " + $scope.ratings[0].current + "/" + $scope.ratings[0].max
                + "\n" + "Second rate: " + $scope.ratings[1].current + "/" + $scope.ratings[0].max);

    };
});

starApp.directive('starRating', function () {
    return {
        restrict: 'A',
        template: '<ul class="rating">' +
                '<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">' +
                '\u2605' +
                '</li>' +
                '</ul>',
        scope: {
            ratingValue: '=',
            max: '=',
            readonly: '=',
            onRatingSelected: '&',
            isClick: '='
        },
        link: function (scope, elem, attrs) {

            var updateStars = function () {
                scope.stars = [];
                for (var i = 0; i < scope.max; i++) {
                    scope.stars.push({
                        filled: i < scope.ratingValue
                    });
                }
            };

            scope.toggle = function (index) {
                if (scope.readonly === false) {
                    scope.ratingValue = index + 1;
                    scope.onRatingSelected({rating: scope});
                    scope.isClick = true;
                }
            };

            scope.$watch('ratingValue', function (oldVal, newVal) {
                if (newVal) {
                    updateStars();
                    if (scope.isClick) {
                        scope.onRatingSelected({
                            rating: scope
                        });
                        scope.isClick = false;
                    }
                }
            });
        }
    };
});