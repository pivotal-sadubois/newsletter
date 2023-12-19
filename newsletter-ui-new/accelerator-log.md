# Accelerator Log

## Options
```json
{
  "projectName" : "angular-frontend",
  "artifactId" : "angular-frontend",
  "backendService" : "customer-profile-backend.namespace",
  "useSingleSignOn" : false,
  "authority" : "",
  "authorityLabelKey" : "",
  "authorityLabelValue" : "",
  "namespace" : "<your-namespace>",
  "bsGitRepository" : "github.com?owner=sdubois-tapdemo&repo=angular-frontend",
  "bsGitBranch" : "main"
}
```
## Log
```
┏ engine (Chain)
┃  Info Running Chain(GeneratorValidationTransform, UniquePath)
┃ ┏ ┏ engine.transformations[0].validated (Combo)
┃ ┃ ┃  Info Combo running as Let
┃ ┃ ┃ engine.transformations[0].validated.delegate (Let)
┃ ┃ ┃ Debug Adding symbol backendServiceResourceName with value 'customer-profile-backend.namespace'
┃ ┃ ┃ Debug Adding symbol workloadResourceName with value 'angular-frontend'
┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in (Chain)
┃ ┃ ┃ ┃  Info Running Chain(Combo, Combo, Combo, Combo, Combo, Combo, Provenance)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[0] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[0].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[0].delegate.transformations[0] (ReplaceText)
┃ ┃ ┃ ┃ ┗ ┗  Info Will replace [http://backend/api/->http://customer-prof...(truncated)]
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[1] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[1].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[1].delegate.transformations[0] (ReplaceText)
┃ ┃ ┃ ┃ ┗ ┗  Info Will replace [angular-frontend->angular-frontend]
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2] (Combo)
┃ ┃ ┃ ┃ ┗  Info Condition (#useSingleSignOn == true) evaluated to false
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[3].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(Merge, UniquePath)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0] (Merge)
┃ ┃ ┃ ┃ ┃ ┃  Info Running Merge(InvokeFragment, Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0] (InvokeFragment)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0].validated (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Condition (#bsGitRepository != null) evaluated to true
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Let
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0].validated.delegate (Let)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug Adding symbol repoUrl with value 'https://github.com?owner=sdubois-tapdemo&repo=angular-frontend'
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0].validated.delegate.in (Chain)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Running Chain(OpenRewriteRecipe, ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ╺ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0].validated.delegate.in.transformations[0] (OpenRewriteRecipe)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[0].validated.delegate.in.transformations[1] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┗ ┗ ┗ ┗  Info Will replace regex '(?<beforeBranch>[\s\S]+)(?<branch>branch: [\S]+)(?<rest>[\S\s]*)' with '${beforeBranch}branc...(truncated)'
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[1] (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Include
┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[0].sources[1].delegate (Include)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will include [**]
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug AUTHORIZATION.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-config.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/auth.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/AuthorizationTypes.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization-config.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┗ ┗ Debug config/workload.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[3].delegate.transformations[1] (UniquePath)
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/home.component.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/app-config.service.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/utils.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'karma.conf.js', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'angular.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'AUTHORIZATION.md', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/environments/environment.prod.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/create-customer-profile.component.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/environments/environment.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.service.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path '.editorconfig', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authorization.service.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'LICENSE', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/favicon.ico', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authorization-config.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'nginx.conf', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/configTypes.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/top-bar/top-bar.component.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/app.module.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'DeploymentTopology.png', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/polyfills.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/index.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/proxy.conf.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.service.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.module.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'README.md', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/create-customer-profile.component.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/assets/auth.conf.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/create-customer-profile.component.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'tsconfig.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/home.component.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'tekton/README.md', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'tsconfig.app.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authentication-utilities.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/app-routing.module.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path '.gitignore', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'tsconfig.spec.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'package-lock.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/test.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/customer-profile.service.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/list-customer-profiles.component.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/home.component.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/top-bar/top-bar.component.css', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/list-customer-profiles.component.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/customer-profile.service.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'tekton/test-pipeline.yaml', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/list-customer-profiles.component.css', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/AuthorizationTypes.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authInterceptor.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path '.tanzuignore', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.component.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authentication-utilities.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/home.component.css', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/create-customer-profile.component.css', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.component.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/user-profile/user-profile.component.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/authorization/authInterceptor.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/list-customer-profiles.component.html', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'catalog/catalog-info.yaml', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/main.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'config/workload.yaml', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/assets/.gitkeep', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path '.browserslistrc', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/top-bar/top-bar.component.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'package.json', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/customer-profile/customer-profile.module.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/app/utils.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┃ ┃ Debug Multiple representations for path 'src/styles.css', will use the one appearing first 
┃ ┃ ┃ ┃ ┗ ┗ Debug Multiple representations for path 'src/app/authorization/authorization.service.spec.ts', will use the one appearing first 
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4] (Combo)
┃ ┃ ┃ ┃ ┃  Info Condition (!#useSingleSignOn) evaluated to true
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[4].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(Merge, UniquePath)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0] (Merge)
┃ ┃ ┃ ┃ ┃ ┃  Info Running Merge(Combo, Combo, Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[0] (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[0].delegate (Chain)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Running Chain(Include, Exclude)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[0].delegate.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will include [**]
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-config.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug AUTHORIZATION.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization-config.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/auth.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/AuthorizationTypes.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ Debug src/app/authorization/authorization.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[0].delegate.transformations[1] (Exclude)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will exclude [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts]
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-config.service.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug AUTHORIZATION.md matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.spec.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization-config.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.module.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/auth.conf.json matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/AuthorizationTypes.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.html matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.spec.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.spec.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.spec.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css didn't match [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┗ ┗ Debug src/app/authorization/authorization.service.spec.ts matched [README.md, src/app/app.module.ts, src/app/app-routing.module.ts, AUTHORIZATION.md, src/app/authorization/**, src/app/user-profile/**, src/assets/auth.conf.json, src/app/app-config.service.ts, src/utils.ts, src/utils.spec.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1] (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate (Chain)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Running Chain(Include, ReplaceText, ReplaceText, ReplaceText, ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will include [src/app/app.module.ts, src/app/app-routing.module.ts]
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-config.service.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug AUTHORIZATION.md didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization-config.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [src/app/app.module.ts, src/app/app-routing.module.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.module.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/auth.conf.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [src/app/app.module.ts, src/app/app-routing.module.ts] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/AuthorizationTypes.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ Debug src/app/authorization/authorization.service.spec.ts didn't match [src/app/app.module.ts, src/app/app-routing.module.ts] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate.transformations[1] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗  Info Will replace regex '// StartSSOImports[\s\S]+?// EndSSOImports' with ''
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate.transformations[2] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗  Info Will replace regex '// StartSSOProviders[\s\S]+?// EndSSOProviders' with ''
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate.transformations[3] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗  Info Will replace regex '// StartSSOModules[\s\S]+?// EndSSOModules' with ''
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[1].delegate.transformations[4] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┗ ┗  Info Will replace regex '// StartSSORoutes[\s\S]+?// EndSSORoutes' with ''
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[2] (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[2].delegate (Chain)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Running Chain(Include, ReplaceText)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[2].delegate.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will include [README.md]
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-config.service.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug AUTHORIZATION.md didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization.service.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authorization-config.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.service.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.module.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [README.md] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/auth.conf.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/AuthorizationTypes.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authentication-utilities.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/user-profile/user-profile.component.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/authorization/authInterceptor.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ Debug src/app/authorization/authorization.service.spec.ts didn't match [README.md] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[0].sources[2].delegate.transformations[1] (ReplaceText)
┃ ┃ ┃ ┃ ┃ ┗ ┗ ┗  Info Will replace regex '--- StartAuthorization[\s\S]+?--- EndAuthorization' with ''
┃ ┃ ┃ ┃ ┗ ╺ engine.transformations[0].validated.delegate.in.transformations[4].delegate.transformations[1] (UniquePath)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[5] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[5].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(Include, Exclude)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[5].delegate.transformations[0] (Include)
┃ ┃ ┃ ┃ ┃ ┃  Info Will include [**]
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug package.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┗ Debug src/styles.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[5].delegate.transformations[1] (Exclude)
┃ ┃ ┃ ┃ ┃ ┃  Info Will exclude [tekton/**]
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.spec.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.html didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/configTypes.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug README.md didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.spec.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/README.md matched [tekton/**] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.spec.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug tekton/test-pipeline.yaml matched [tekton/**] -> excluded
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.service.spec.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.css didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/create-customer-profile.component.css didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/list-customer-profiles.component.html didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug config/workload.yaml didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug package.json didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/utils.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/customer-profile/customer-profile.module.ts didn't match [tekton/**] -> included
┃ ┃ ┃ ┃ ┗ ┗ Debug src/styles.css didn't match [tekton/**] -> included
┃ ┗ ┗ ┗ ╺ engine.transformations[0].validated.delegate.in.transformations[6] (Provenance)
┗ ╺ engine.transformations[1] (UniquePath)
```
