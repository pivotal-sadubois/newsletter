# Accelerator Log

## Options
```json
{
  "artifactId" : "newsletter-ui",
  "backendService" : "newsletter-subscription.newsletter",
  "projectName" : "newsletter-ui"
}
```
## Log
```
┏ engine (Chain)
┃  Info Running Chain(GeneratorValidationTransform, UniquePath)
┃ ┏ ┏ engine.transformations[0].validated (Combo)
┃ ┃ ┃  Info Combo running as Let
┃ ┃ ┃ engine.transformations[0].validated.delegate (Let)
┃ ┃ ┃ Debug Adding symbol backendServiceResourceName with value 'newsletter-subscription.newsletter'
┃ ┃ ┃ Debug Adding symbol workloadResourceName with value 'newsletter-ui'
┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in (Chain)
┃ ┃ ┃ ┃  Info Running Chain(Combo, Combo, Combo)
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[0] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[0].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[0].delegate.transformations[0] (ReplaceText)
┃ ┃ ┃ ┃ ┗ ┗  Info Will replace [http://backend/api/->http://newsletter-su...(truncated)]
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[1] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[1].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(ReplaceText)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[1].delegate.transformations[0] (ReplaceText)
┃ ┃ ┃ ┃ ┗ ┗  Info Will replace [angular-frontend->newsletter-ui]
┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2] (Combo)
┃ ┃ ┃ ┃ ┃  Info Combo running as Chain
┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[2].delegate (Chain)
┃ ┃ ┃ ┃ ┃  Info Running Chain(Merge, UniquePath)
┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[0] (Merge)
┃ ┃ ┃ ┃ ┃ ┃  Info Running Merge(InvokeFragment, Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[0].sources[0] (InvokeFragment)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[0].sources[0].validated (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Condition (#bsGitRepository != null) evaluated to false
┃ ┃ ┃ ┃ ┃ ┃ ┗ ┗ null ()
┃ ┃ ┃ ┃ ┃ ┃ ┏ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[0].sources[1] (Combo)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Combo running as Include
┃ ┃ ┃ ┃ ┃ ┃ ┃ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[0].sources[1].delegate (Include)
┃ ┃ ┃ ┃ ┃ ┃ ┃  Info Will include [**]
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .browserslistrc matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .editorconfig matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .gitignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug .tanzuignore matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug DeploymentTopology.png matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug LICENSE matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug README.md matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug angular.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug config/test-pipeline.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug karma.conf.js matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package-lock.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug package.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app-routing.module.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/app.module.ts matched [**] -> included
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
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.spec.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/home.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/app/top-bar/top-bar.component.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/assets/.gitkeep matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.prod.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/environments/environment.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/favicon.ico matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/index.html matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/main.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/polyfills.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/proxy.conf.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/styles.css matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug src/test.ts matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.app.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug tsconfig.spec.json matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug nginx.conf matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┃ ┃ Debug catalog/catalog-info.yaml matched [**] -> included
┃ ┃ ┃ ┃ ┃ ┗ ┗ Debug config/workload.yaml matched [**] -> included
┃ ┗ ┗ ┗ ┗ ╺ engine.transformations[0].validated.delegate.in.transformations[2].delegate.transformations[1] (UniquePath)
┗ ╺ engine.transformations[1] (UniquePath)
```
