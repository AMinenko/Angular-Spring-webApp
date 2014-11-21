angular.module( 'ngBoilerplate', [
  'templates-app',
  'templates-common',
  'ngBoilerplate.home',
  'ngBoilerplate.about',
  'ngBoilerplate.mail',
  'ngBoilerplate.main',
  'ngBoilerplate.settings',
  'ui.router'
])

.config( function myAppConfig ( $stateProvider, $urlRouterProvider ) {
  $urlRouterProvider.otherwise( '/main' );
})

.run( function run () {
})

.controller( 'AppCtrl', function AppCtrl ( $scope, $location ) {
  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | ngBoilerplate' ;
    }
  });


        $scope.selectedMail = undefined;

        $scope.setSelectedMail = function(mail){
            $scope.selectedMail = mail;
        };

        $scope.isSelected = function(mail){
            if($scope.selectedMail){
                return $scope.selectedMail === mail;
            }
        };


});

