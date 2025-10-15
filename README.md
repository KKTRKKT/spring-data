# Spring Data JPA 학습 예제

이 프로젝트는 Spring Data JPA를 학습하기 위한 예제 모음입니다.

## 목차

### 1. JPA 기초
- [1.1 Entity](#11-entity)
- [1.2 Entity 상태 (State)](#12-entity-상태-state)
- [1.3 Value 타입](#13-value-타입)
- [1.4 Entity 생명주기 (Life Cycle)](#14-entity-생명주기-life-cycle)

### 2. 연관관계
- [2.1 Relation (관계 매핑)](#21-relation-관계-매핑)
- [2.2 Cascade](#22-cascade)
- [2.3 Fetch](#23-fetch)

### 3. 쿼리
- [3.1 Query (JPQL, Criteria, SQL)](#31-query-jpql-criteria-sql)

### 4. Spring Data JPA
- [4.1 Spring Data JPA 기본](#41-spring-data-jpa-기본)

### 5. Spring Data Common
- [5.1 Repository](#51-repository)
- [5.2 Repository Interface](#52-repository-interface)
- [5.3 Query 생성 전략](#53-query-생성-전략)
- [5.4 Custom Repository](#54-custom-repository)
- [5.5 Custom JPA Repository](#55-custom-jpa-repository)
- [5.6 QueryDSL](#56-querydsl)
- [5.7 Domain Event](#57-domain-event)
- [5.8 Web Support](#58-web-support)
  - [5.8.1 Pageable과 Sort](#581-pageable과-sort)
  - [5.8.2 Domain Converter](#582-domain-converter)
  - [5.8.3 HATEOAS](#583-hateoas)

### 6. JPA Repository 고급 기능
- [6.1 Enable JPA Repositories](#61-enable-jpa-repositories)
- [6.2 Repository Annotation](#62-repository-annotation)
- [6.3 Query와 Sort](#63-query와-sort)
- [6.4 Projection](#64-projection)
- [6.5 Specification](#65-specification)
- [6.6 Entity Graph](#66-entity-graph)
- [6.7 Auditing](#67-auditing)

---

## 상세 설명

### 1. JPA 기초

#### 1.1 Entity
**패키지**: `me.kktrkkt.springdata.entity`

Entity 관련 애노테이션에 대해서 살펴봅니다.

**주요 내용**:
- `@Entity` 애노테이션 사용법
- 기본 키 매핑 전략
- 컬럼 매핑
- HibernateJpaAutoConfiguration을 통한 자동 설정
- `spring.jpa.hibernate.ddl-auto` 옵션 (create, update)

#### 1.2 Entity 상태 (State)
**패키지**: `me.kktrkkt.springdata.state`

JPA 엔티티의 4가지 상태에 대해 알아봅니다.

**주요 내용**:
- **Transient**: JPA가 모르는 상태
- **Persistent**: JPA가 관리하는 상태 (1차 캐싱, dirty checking 등 지원)
- **Detached**: JPA가 더 이상 관리하지 않는 상태
- **Removed**: JPA에서 관리하지만 삭제하기로 한 상태

#### 1.3 Value 타입
**패키지**: `me.kktrkkt.springdata.value`

Composite Value 타입 사용법을 알아봅니다.

**주요 내용**:
- Entity vs Value 개념
- Entity는 독립적이고 식별자가 필요
- Value는 Entity에 종속
- `@Embeddable`, `@Embedded` 사용법

#### 1.4 Entity 생명주기 (Life Cycle)
**패키지**: `me.kktrkkt.springdata.life_cycle`

엔티티 생명주기별 콜백 메소드 사용 방법에 대해 알아봅니다.

**주요 내용**:
- `@PrePersist`, `@PostPersist`
- `@PreUpdate`, `@PostUpdate`
- `@PreRemove`, `@PostRemove`
- `@PostLoad`

**주의점**: 콜백 메소드에서는 EntityManager 또는 Query를 호출해서는 안됩니다.

### 2. 연관관계

#### 2.1 Relation (관계 매핑)
**패키지**: `me.kktrkkt.springdata.relation`

테이블 간의 관계와 주종관계에 대해 알아봅니다.

**주요 내용**:
- FK 키를 가지고 있는 쪽이 주인
- 영속화는 주인쪽에서 진행
- **단방향 관계**:
  - `@ManyToOne`: 관계 정의한 쪽에 FK 키 생성
  - `@OneToMany`: 매핑 테이블 생성
- **양방향 관계**:
  - `@ManyToOne` + `@OneToMany(mappedBy)`
  - `@ManyToOne`이 주인

#### 2.2 Cascade
**패키지**: `me.kktrkkt.springdata.cascade`

Cascade 사용법에 대해 알아봅니다.

**주요 내용**:
- 영속성 전이 (Cascade) 옵션
- `CascadeType.ALL`, `PERSIST`, `MERGE`, `REMOVE` 등

#### 2.3 Fetch
**패키지**: `me.kktrkkt.springdata.fetch`

연관관계 엔티티를 로딩하는 방법에 대해 알아봅니다.

**주요 내용**:
- Lazy Loading vs Eager Loading
- N+1 문제와 성능 최적화
- `@OneToMany`: 기본 Lazy 로딩
- `@ManyToOne`: 기본 Eager 로딩

### 3. 쿼리

#### 3.1 Query (JPQL, Criteria, SQL)
**패키지**: `me.kktrkkt.springdata.query`

JPA에서 사용하는 3가지 쿼리 방법에 대해서 알아봅니다.

**주요 내용**:
- **JPQL**: 객체지향 쿼리 언어
- **Criteria**: 타입 세이프한 쿼리 빌더
- **Native SQL**: 데이터베이스 네이티브 쿼리

### 4. Spring Data JPA

#### 4.1 Spring Data JPA 기본
**패키지**: `me.kktrkkt.springdata.spring_data_jpa`

Spring Data JPA를 통해 Repository를 등록하는 방법과 간단한 원리를 알아봅니다.

**주요 내용**:
- `@SpringBootApplication`에 의한 자동 설정
- `@Configuration`, `@EnableJpaRepositories` 자동 적용
- JpaRepository 인터페이스 사용법

### 5. Spring Data Common

#### 5.1 Repository
**패키지**: `me.kktrkkt.springdata.spring_data_common.repository`

Spring Data Common의 Repository에 대해 알아봅니다.

**주요 내용**:
- Repository 인터페이스 계층 구조
- `Repository` → `CrudRepository` → `PagingAndSortingRepository` → `JpaRepository`
- 각 인터페이스가 제공하는 기능

#### 5.2 Repository Interface
**패키지**: `me.kktrkkt.springdata.spring_data_common.repositoryInterface`

커스텀 Repository 인터페이스를 만드는 방법에 대해 알아봅니다.

**주요 내용**:
- `@RepositoryDefinition`을 이용한 기능 일일히 정의
- `@NoRepositoryBean`을 이용한 커스텀 인터페이스 생성

#### 5.3 Query 생성 전략
**패키지**: `me.kktrkkt.springdata.spring_data_common.query`

Spring Data JPA의 쿼리 생성 전략에 대해 알아봅니다.

**주요 내용**:
- **CREATE**: 메소드 이름을 분석해 쿼리 생성
- **USE_DECLARED_QUERY**: 미리 정의한 쿼리를 찾아 사용
- **CREATE_IF_NOT_FOUND** (기본): 미리 정의한 쿼리를 찾고 없으면 메소드 이름 분석
- `@EnableJpaRepositories`의 `queryLookupStrategy` 옵션

#### 5.4 Custom Repository
**패키지**: `me.kktrkkt.springdata.spring_data_common.custom_repository`

커스텀 Repository를 만드는 방법을 배웁니다.

**주요 내용**:
1. 커스텀 Repository 인터페이스 선언
2. Repository 구현체 작성
3. 기존 JPA Repository에 extends로 추가
4. (옵션) 구현 Repository postfix 변경 (`repositoryImplementationPostfix`)

#### 5.5 Custom JPA Repository
**패키지**: `me.kktrkkt.springdata.spring_data_common.custom_jpa_repository`

JPA Repository 자체를 커스터마이징하는 방법에 대해 알아봅니다.

**주요 내용**:
- JpaRepository에 공통 기능 추가
- `SimpleJpaRepository` 커스터마이징
- `@EnableJpaRepositories(repositoryBaseClass)` 설정

#### 5.6 QueryDSL
**패키지**: `me.kktrkkt.springdata.spring_data_common.query_dsl`

타입 세이프하면서 단순한 쿼리 생성 도구인 QueryDSL에 대해 알아봅니다.

**주요 내용**:
- 메소드 이름이 길어지는 문제 해결
- JPQL vs Criteria vs QueryDSL 비교
- 타입 세이프하면서 코드가 단순
- Q-Type 생성 및 사용법

#### 5.7 Domain Event
**패키지**: `me.kktrkkt.springdata.spring_data_common.domain_event`

Spring Data Common에서 지원하는 Domain Event 기능에 대해 알아봅니다.

**주요 내용**:
- JpaRepository 사용 시 자동 이벤트 발행
- `@DomainEvents`, `@AfterDomainEventPublication`
- 이벤트 리스너 구현

#### 5.8 Web Support

##### 5.8.1 Pageable과 Sort
**패키지**: `me.kktrkkt.springdata.spring_data_common.web_support.pageabble_and_sort`

Pageable과 Sort 기능에 대해 알아봅니다.

**주요 내용**:
- Controller 메소드 파라미터로 Pageable, Sort 자동 주입
- 페이징 및 정렬 파라미터 처리
- 커스텀 설정 방법

##### 5.8.2 Domain Converter
**패키지**: `me.kktrkkt.springdata.spring_data_common.web_support.domain_converter`

도메인 컨버터에 대해 알아봅니다.

**주요 내용**:
- ID를 자동으로 엔티티에 매핑
- `DomainClassConverter` 동작 원리
- Controller에서 ID → Entity 자동 변환

##### 5.8.3 HATEOAS
**패키지**: `me.kktrkkt.springdata.spring_data_common.web_support.hateoas`

Spring Data Common의 HATEOAS 지원 기능에 대해 알아봅니다.

**주요 내용**:
- 관련 링크 정보 자동 생성
- 클라이언트의 링크 생성 부담 감소
- `PagedResourcesAssembler` 사용법

### 6. JPA Repository 고급 기능

#### 6.1 Enable JPA Repositories
**패키지**: `me.kktrkkt.springdata.jpa_repository.enable_jpa_repsitories`

`@EnableJpaRepositories` 애노테이션에 대해 알아봅니다.

**주요 내용**:
- JpaRepository 타입을 찾아서 빈으로 등록
- Spring Boot에서는 기본 설정으로 선언됨
- `basePackages` 설정을 통한 스캔 범위 지정

#### 6.2 Repository Annotation
**패키지**: `me.kktrkkt.springdata.jpa_repository.repository_annotation`

Repository 애노테이션의 역할에 대해 알아봅니다.

**주요 내용**:
- `SimpleJpaRepository`의 `@Repository`, `@Transactional(readOnly=true)` 설정
- 예외 변환: SQLException/JPA 예외 → DataAccessException

#### 6.3 Query와 Sort
**패키지**: `me.kktrkkt.springdata.jpa_repository.query_and_sort`

`@Query`와 Sort를 함께 사용하는 방법에 대해 알아봅니다.

**주요 내용**:
- 엔티티 속성 또는 alias만 정렬 가능
- DB 함수 사용 제한
- `JpaSort`를 사용한 DB 함수 정렬

#### 6.4 Projection
**패키지**: `me.kktrkkt.springdata.jpa_repository.projection`

엔티티의 일부 데이터만 가져오는 Projection 기능에 대해 알아봅니다.

**주요 내용**:
- Interface 기반 Projection
- Class 기반 Projection (DTO)
- Dynamic Projection
- 성능 최적화

#### 6.5 Specification
**패키지**: `me.kktrkkt.springdata.jpa_repository.specification`

QueryDSL과 유사한 쿼리 작성 도구인 Specification에 대해 알아봅니다.

**주요 내용**:
- Criteria API 기반
- and, or 조건 조합 가능
- QueryDSL보다 문법이 복잡하지만 조합 기능 강력

#### 6.6 Entity Graph
**패키지**: `me.kktrkkt.springdata.jpa_repository.entity_graph`

쿼리 또는 메소드마다 연관관계 Fetch 전략을 설정하는 방법에 대해 알아봅니다.

**주요 내용**:
- `@NamedEntityGraph`, `@EntityGraph` 사용
- **FETCH 전략** (기본): 지정한 속성은 EAGER, 나머지는 LAZY
- **LOAD 전략**: 지정한 속성은 EAGER, 나머지는 기본 설정

#### 6.7 Auditing
**패키지**: `me.kktrkkt.springdata.jpa_repository.auditing`

엔티티 생성/변경 시점과 사용자 추적 기능인 Auditing에 대해 알아봅니다.

**주요 내용**:
1. `@EnableJpaAuditing` 설정 추가
2. 엔티티에 `@EntityListeners(AuditingEntityListener.class)` 추가
3. `AuditorAware<T>` 구현체를 빈으로 등록
4. `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, `@LastModifiedBy` 사용

---

## 실행 방법

각 예제는 독립적인 `Application.java`를 가지고 있습니다. 원하는 예제의 Application 클래스를 실행하면 됩니다.

```bash
# 예시: Entity 예제 실행
./mvnw spring-boot:run -Dspring-boot.run.main-class=me.kktrkkt.springdata.entity.Application
```

## 기술 스택

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (개발용)

## 라이선스

이 프로젝트는 학습 목적으로 작성되었습니다.
