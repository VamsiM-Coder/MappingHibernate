Hibernate SQL Relationship Mapping Overview :

In this project, we use Hibernate ORM to map Java entities to a MySQL relational database using various types of relationships. These mappings follow standard JPA annotations to define how entities relate to each other. Here's a summary of the key relationship types used:

 >  One-to-One (@OneToOne)

       > Represents a one-to-one relationship between two entities.
       > Each row in one table corresponds to exactly one row in another table.
       
 EX : Typically used for entities that share the same lifecycle (e.g., User ↔ UserProfile).
      @OneToOne
      @JoinColumn(name = "profile_id")
      private UserProfile profile; 
         
       > Use Case: A User has exactly one UserProfile.

  >  One-to-Many (@OneToMany) & Many-to-One (@ManyToOne)
 
       > Represents a parent-child relationship where one entity is related to many others.
       > In database terms, the "many" side has a foreign key to the "one" side.

   Ex: Annotated on the parent side with @OneToMany and on the child side with @ManyToOne.
       // Parent side (e.g., User.java)
       @OneToMany(mappedBy = "user")
       private List<Repository> repositories;
       // Child side (e.g., Repository.java)
       @ManyToOne
       @JoinColumn(name = "user_id")
       private User user;
       
       > Use Case: A User can own multiple Repositories.

   >  Many-to-Many (@ManyToMany)

       > Represents a relationship where many entities can be related to many others.
       > Requires a join table in the database to manage the association.
       > Bidirectional or unidirectional mapping supported.
  Ex:
      @ManyToMany
      @JoinTable(
      name = "repository_stars",
      joinColumns = @JoinColumn(name = "repository_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
      private List<User> stargazers;
      
      > Use Case: A Repository can be starred by many Users, and a User can star many Repositories.

Summary :

    > One-to-One	@OneToOne	Foreign Key	User ↔ UserProfile
    > One-to-Many	@OneToMany	Foreign Key (on Many)	User → Repositories
    > Many-to-One	@ManyToOne	Foreign Key (on Many)	Repository → User  
    > Many-to-Many	@ManyToMany	Join Table	Repository ↔ Stargazers (Users)
