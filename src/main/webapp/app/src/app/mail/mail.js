angular.module('ngBoilerplate.mail', ['ui.router'])
    .config(function ($stateProvider) {
        $stateProvider.state('mail', {
            url: '/mail',
            views: {
                'main': {
                    templateUrl: 'mail/mail.tpl.html',
                    controller: 'MailController'
                }
            },
            data: { pageTitle: 'Mail page' }
        });

    })

.controller("MailController", function ($scope, $http) {
        $scope.email = [];

        $http({
                method: 'GET',
                url: '/basic-web-app/getAllMails'
        })
        .success(function (data, status, headers) {
            $scope.email=data.all;
        })
        .error(function (data, status, headers) {

    });
});