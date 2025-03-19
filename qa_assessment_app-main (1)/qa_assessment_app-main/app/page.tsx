// app/page.tsx
'use client';

import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

const HomePage = () => {
  const router = useRouter();

  useEffect(() => {
    router.push('/login');
  }, [router]);

  return (
    <div>
      <h1>Redirecting...</h1>
      <p>If you&apos;re not redirected, click <a href="/login">here</a>.</p>
    </div>
  );
};

export default HomePage;
