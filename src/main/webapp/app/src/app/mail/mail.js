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
    //    $http.defaults.headers.post["Content-Type"] = "application/json";

        $scope.email = [];
        $scope.selectedMail = undefined;
        $scope.reply={};
        $scope.showingReply=false;

        $http({
            method: 'GET',
            url: '/basic-web-app/getAllMails'
            })
            .success(function (data, status, headers) {
                $scope.email=data.all;
            })
            .error(function (data, status, headers) {

         });

       $scope.sendReply = function(reply) {
           $http.post('/basic-web-app/postMail', reply).success(function(reply,status,headers,config){
               console.log(reply);
           });
       };

        $scope.setSelectedMail = function(mail){
            $scope.selectedMail = mail;
            $scope.reply={};

        };

        $scope.isSelected = function(mail){
            if($scope.selectedMail){
                return $scope.selectedMail === mail;
            }
        };

        $scope.toggleReplyForm =  function(){
              $scope.showingReply=!$scope.showingReply;
              $scope.reply.to = $scope.selectedMail.from;
              $scope.reply.body = "\n---------------------------- \n\n" + $scope.selectedMail.body;

        };





        $scope.postReply =  function(reply){
                console.log(reply);
                var postObject = {};
                postObject.id = reply.id;
                postObject.from = reply.from;
                postObject.to = reply.to;
                postObject.subject = reply.subject;
                postObject.body = reply.body;

                console.log(postObject);
                $http({method: 'POST', url: '/basic-web-app/postMail', data: postObject});
            /*
             {
             ,
             data: reply,
             headers: {'Content-Type': 'application/json'}
             }
             */
        };

       /* $scope.watch('selectedMail', function(evt){
           $scope.showingReply = false;
            $scope.reply = {};
        });*/


});