const React = require("react");

const CompLibrary = require("../../core/CompLibrary.js");
const Container = CompLibrary.Container;
const GridBlock = CompLibrary.GridBlock;

const siteConfig = require(process.cwd() + "/siteConfig.js");

function imgUrl(img) {
  return siteConfig.baseUrl + "img/" + img;
}

function docUrl(doc, language) {
  return siteConfig.baseUrl + "docs/" + (language ? language + "/" : "") + doc;
}

class Button extends React.Component {
  render() {
    return (
      <div className="pluginWrapper buttonWrapper">
        <a className="button" href={this.props.href} target={this.props.target}>
          {this.props.children}
        </a>
      </div>
    );
  }
}

Button.defaultProps = {
  target: "_self",
};

const SplashContainer = (props) => (
  <div className="homeContainer">
    <div className="homeSplashFade">
      <div className="wrapper homeWrapper">{props.children}</div>
    </div>
  </div>
);

const ProjectTitle = (props) => (
  <h2 className="projectTitle">
    {siteConfig.title}
    <small>{siteConfig.tagline}</small>
  </h2>
);

const PromoSection = (props) => (
  <div className="section promoSection">
    <div className="promoRow">
      <div className="pluginRowBlock">{props.children}</div>
    </div>
  </div>
);

class HomeSplash extends React.Component {
  render() {
    let language = this.props.language || "";
    return (
      <SplashContainer>
        <div className="inner">
          <ProjectTitle />
          <PromoSection>
            <Button href={docUrl("getting-started.html", language)}>
              Get Started
            </Button>
          </PromoSection>
        </div>
      </SplashContainer>
    );
  }
}

const Block = (props) => (
  <Container
    padding={["bottom", "top"]}
    id={props.id}
    background={props.background}
  >
    <GridBlock align="left" contents={props.children} layout={props.layout} />
  </Container>
);

const Features = (props) => {
  const features = [
    // {
    //   title: "Multiple language versions",
    //   content: "Works with Java 8, Java 11 and Java 15.",
    //   image:
    //     "https://user-images.githubusercontent.com/1408093/109818700-93378e00-7c33-11eb-8385-7ea88533cb87.png",
    //   imageAlign: "left"
    // },
    {
      title: "Multiple languages",
      content:
        "Java, Scala and Kotlin are supported, including navigation between different languages.",
      image:
        "https://user-images.githubusercontent.com/1408093/137899150-e8d92cdd-8bd2-4802-9cd2-288442708aff.png",
      imageAlign: "left",
    },
    {
      title: "Multiple build tools",
      content:
        "The build tools Gradle, Maven, Mill, and sbt are supported. We plan to add support for more build tools in the future.",
      image:
        "https://user-images.githubusercontent.com/1408093/137899144-cfc6fc1b-a7c0-4fd7-ac4b-be516e459123.png",
      imageAlign: "right",
    },
    {
      title: "Simple installation",
      content:
        "Run the `scip-java` command-line tool at the root of your Gradle/Maven/sbt build to generate an SCIP index. No manual configuration needed.",
      image:
        "https://storage.googleapis.com/sourcegraph-assets/blog/scip-java-simple-install.png",
      imageAlign: "left",
    },
    {
      title: "Low overhead",
      content:
        "Indexing a repository should be roughly as fast as compiling all of the sources in the repository.",
      image:
        "https://user-images.githubusercontent.com/1408093/109820240-1dccbd00-7c35-11eb-8a87-6b1850687e28.png",
      imageAlign: "right",
    },
  ];
  return (
    <div
      className="productShowcaseSection paddingBottom"
      style={{ textAlign: "left" }}
    >
      {features.map((feature) => (
        <Block key={feature.title}>{[feature]}</Block>
      ))}
    </div>
  );
};
class Index extends React.Component {
  render() {
    let language = this.props.language || "";

    return (
      <div>
        <HomeSplash language={language} />
        <Features />
      </div>
    );
  }
}

module.exports = Index;
