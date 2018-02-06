**Spring4.x高级话题(一):Spring Aware**
Spring的依赖注入最大亮点就是所有的Bean对Spring容器的存在是没有意识的。

但是在实际项目中，不可避免的要用到Spring容器本身的功能资源，这时你的Bean必须要意识到Spring容器的存在，
才能调用Spring所提供的资源，这就是所谓的Spring Aware。其实Spring Aware本来就是Spring设计用来框架内部使用的，
若使用Spring Aware，你的Bean将会和Spring框架耦合。

