angular.module('ngBoilerplate.settings',['ui.router'])
    .config(function($stateProvider){
        $stateProvider.state('settings',{
            url:'/settings',
            views:{
                'main':{
                    templateUrl:"settings/settings.tpl.html"
                }
            },
            data:{ pageTitle: 'Settings page' }

        });

    });