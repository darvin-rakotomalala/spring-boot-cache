## Spring Boot - Cache

Dans cet repo, nous allons voir comment activer, configurer le cache dans Spring Boot.

**Pourquoi utiliser le cache dans Spring Boot ?**
Nous utilisons principalement un cache en mémoire afin d'améliorer les performances de notre application. Par exemple,
supposons que vous souhaitiez une méthode lourde en calcul qui prend beaucoup de temps pour renvoyer le résultat. Si
vous n'utilisez pas la mise en cache, vous devrez calculer les mêmes choses chaque fois que la méthode est appelée,
cependant, si vous utilisez la mise en cache, vous pouvez enregistrer le résultat dans une structure de données Map et
obtenir le résultat en calcul O(1) temps.

Néanmoins, rien n'a de prix, car avec la mise en cache, il est possible d'avoir une surcharge de mémoire, et en même
temps, nous devons faire attention à la configuration du cache afin de ne pas servir de données obsolètes.

### Exemples

- Utilisation de `@Cacheable` pour mettre en cache le résultat d'une méthode : L'annotation `@Cacheable` est utilisée
  pour marquer une méthode comme pouvant être mise en cache. Une chose très importante à propos du cache dans Spring
  Boot est que vous ne devez jamais appeler une méthode `@Cacheable` ou `@CacheEvict` une méthode `@CachePut` annotée de la même
  classe car cela ne fonctionnera jamais.