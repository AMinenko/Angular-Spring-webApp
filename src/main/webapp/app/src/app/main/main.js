angular.module('ngBoilerplate.main',['ui.router'])
    .config(function($stateProvider){
        $stateProvider.state('main',{
           url:'/main',
            views:{
                'main':{
                    templateUrl:"main/main.tpl.html"
                }
            }, data:{pageTitle:"Main page"}
        });

});