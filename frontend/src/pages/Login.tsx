import { Link } from "react-router-dom";

type Props = {
    
};

const Login = (props: Props) => {
    return (
        <div>
            <Link to="/home">
                Login
            </Link>
        </div>
    );
};

export default Login;