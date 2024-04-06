Un projet pour tester les fonctions de Workflows

[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fjoopererer%2FTestMaven.svg?type=shield&issueType=license)](https://app.fossa.com/projects/git%2Bgithub.com%2Fjoopererer%2FTestMaven?ref=badge_shield&issueType=license)
[![codecov](https://codecov.io/gh/joopererer/TestMaven/graph/badge.svg?token=4CAH4MPZO8)](https://codecov.io/gh/joopererer/TestMaven)

Réalisation :
- Workflows/maven.yml  
  - compiler, tester et mise à jour le couverture des tests automatiquement, quand on fait push/pull_request

   
- Workflows/maven-publish.yml  
  - compiler et publier un package dans dépôt de Github Packages, quand on fait release une version


- Badges
  - Codecov: la couverture des test, https://app.codecov.io/
  - Fossa: détection des issues du code, https://app.fossa.com/ 